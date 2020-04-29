//问题一函数节点

function main(event) {
    try {
        var events = JSON.parse(event);
        var env = events.environment;
        var currentIntent = "问题1";
        var prevIntent;
        var alternative;
        events.routeVariable = "正常流程";

        if (env.VENDOR_PARAM) {
            var param = JSON.parse(env.VENDOR_PARAM);
            alternative = param.alternative;
            prevIntent = param.current;
        }

        if (alternative == "1" && prevIntent == currentIntent) {
            events.outputForResponse.htmlText = [{
                "content": "抱歉，我没听清楚，请问您是想到哪个国家或地区留学呢？美国？英国？香港？加拿大？还是澳大利亚？ ",
                "alternative": "2",
                "current": currentIntent,
                "procedures": [{
                    "name": "summarize",
                    "params": "{\"category\":{'category':'顺顺留学'},\"name\":\"顺顺留学-问题1\", \"content\":\"拒识一次\"}"
                }]
            }];
        }
        else if (alternative == "2" && prevIntent == currentIntent) {
            events.routeVariable = "拒识两次"
        }
        else {
            events.outputForResponse.htmlText = [{
                "interruptible": "true",
                "actionParams": "R",
                "content": "y:/10086031/ali/sslx/sslx-a1",
                // "content":"<speak>您好？<break time=\"10000ms\"/>您好！我是顺顺留学李老师，数据显示您在关注出国留学的信息，请问目前是关注哪个国家或地区的信息呢？美国?英国?香港?加拿大?还是澳大利亚？</speak>",
                // "content": "您好？您好！我是顺顺留学李老师，数据显示您在关注出国留学的信息，请问目前是关注哪个国家或地区的信息呢？美国?英国?香港?加拿大?还是澳大利亚？",
                "alternative": "1",
                "current": currentIntent,
                "procedures": [{
                    "name": "summarize",
                    "params": "{\"category\":{'category':'顺顺留学'},\"name\":\"\", \"content\":\"开场白\"}"
                }]
            }];
        }
        return events;
    } catch (e) {
        return e;
    }
}