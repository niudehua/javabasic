//问题三函数节点

function main(event) {
    var eventObj = JSON.parse(event);
    try {
        var slots = eventObj.slotSummary;
        var env = eventObj.environment;
        var glo = eventObj.global;
        if (!eventObj.outputForResponse) {
            eventObj.outputForResponse = {};
        }
        var nickInfo = null;
        if (env && env.VENDOR_PARAM) {
            nickInfo = JSON.parse(env.VENDOR_PARAM);
        }

        eventObj.outputForResponse.htmlText = [{
            "content": "好的，申请出国留学还需要准备语言成绩的，雅思、托福您准备了吗？考了多少分呢？",
            "alternative":1,
            "current":"问题三"
        }];
    } catch (e) {
        if (!eventObj.outputForResponse) {
            eventObj.outputForResponse = {};
        }
        eventObj.outputForResponse.htmlText = [e];
    } finally {
        var eventResult = JSON.stringify(eventObj);
        return eventResult;
    }
};