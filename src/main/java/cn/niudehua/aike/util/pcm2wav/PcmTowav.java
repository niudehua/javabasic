package cn.niudehua.aike.util.pcm2wav;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PcmTowav {
    public static void pcmtowav(String path) throws IOException {
        class WaveHeader {
            WaveHeader() {
            }

            public final char fileID[] = {'R', 'I', 'F', 'F'};
            public int fileLength;
            public char wavTag[] = {'W', 'A', 'V', 'E'};
            public char FmtHdrID[] = {'f', 'm', 't', ' '};
            public int FmtHdrLeth;
            public short FormatTag;
            public short Channels;
            public int SamplesPerSec;
            public int AvgBytesPerSec;
            public short BlockAlign;
            public short BitsPerSample;
            public char DataHdrID[] = {'d', 'a', 't', 'a'};
            public int DataHdrLeth;

            public byte[] getHeader() throws IOException {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                writeChar(bos, fileID);
                writeInt(bos, fileLength);
                writeChar(bos, wavTag);
                writeChar(bos, FmtHdrID);
                writeInt(bos, FmtHdrLeth);
                writeShort(bos, FormatTag);
                writeShort(bos, Channels);
                writeInt(bos, SamplesPerSec);
                writeInt(bos, AvgBytesPerSec);
                writeShort(bos, BlockAlign);
                writeShort(bos, BitsPerSample);
                writeChar(bos, DataHdrID);
                writeInt(bos, DataHdrLeth);
                bos.flush();
                byte[] r = bos.toByteArray();
                bos.close();
                return r;
            }

            private void writeShort(ByteArrayOutputStream bos, int s) throws IOException {
                byte[] mybyte = new byte[2];
                mybyte[1] = (byte) ((s << 16) >> 24);
                mybyte[0] = (byte) ((s << 24) >> 24);
                bos.write(mybyte);
            }

            private void writeInt(ByteArrayOutputStream bos, int n) throws IOException {
                byte[] buf = new byte[4];
                buf[3] = (byte) (n >> 24);
                buf[2] = (byte) ((n << 8) >> 24);
                buf[1] = (byte) ((n << 16) >> 24);
                buf[0] = (byte) ((n << 24) >> 24);
                bos.write(buf);
            }

            private void writeChar(ByteArrayOutputStream bos, char[] id) {
                for (int i = 0; i < id.length; i++) {
                    char c = id[i];
                    bos.write(c);
                }
            }
        }
        String pattern = "([^<>/\\\\\\|:\"\"\\*\\?]+)\\.\\w+$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(path);
        if (!m.find()) {
            System.out.println("文件路径格式错误!");
        }
        System.out.println(m.group(1));
        String name = m.group(1);

        String src = path;
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream("/Users/deng/Desktop/pcmTowav/" + name + ".wav");

        //计算长度
        int PCMSize = 0;
        byte[] buf = new byte[1024 * 4];
        int size = fis.read(buf);

        while (size != -1) {
            PCMSize += size;
            size = fis.read(buf);
        }
        fis.close();

        //填入参数，比特率等等。这里用的是16位单声道 8000 hz
        WaveHeader header = new WaveHeader();
        //长度字段 = 内容的大小（PCMSize) + 头部字段的大小(不包括前面4字节的标识符RIFF以及fileLength本身的4字节)
        header.fileLength = PCMSize + (44 - 8);
        header.FmtHdrLeth = 16;
        header.BitsPerSample = 16;
        header.Channels = 1;
        header.FormatTag = 0x0001;
        header.SamplesPerSec = 8000;
        header.BlockAlign = (short) (header.Channels * header.BitsPerSample / 8);
        header.AvgBytesPerSec = header.BlockAlign * header.SamplesPerSec;
        header.DataHdrLeth = PCMSize;

        byte[] h = header.getHeader();

        assert h.length == 44; //WAV标准，头部应该是44字节
        //write header
        fos.write(h, 0, h.length);
        //write data stream
        fis = new FileInputStream(src);
        size = fis.read(buf);
        while (size != -1) {
            fos.write(buf, 0, size);
            size = fis.read(buf);
        }
        fis.close();
        fos.close();
        System.out.println("Convert OK!");
    }

    public static List<String> getAllFile(String directoryPath, boolean isAddDirectory) {
        List<String> list = new ArrayList<String>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return list;
        }
        File[] files = baseFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                if (isAddDirectory) {
                    list.add(file.getAbsolutePath());
                }
                list.addAll(getAllFile(file.getAbsolutePath(), isAddDirectory));
            } else {
                list.add(file.getAbsolutePath());
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {

        String path = "/Users/deng/Desktop/pcmTowav";

        List<String> pathList = getAllFile(path, false);


        for (String src : pathList) {
            pcmtowav(src);
        }

    }
}
