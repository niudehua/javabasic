//问题二函数节点

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
            "content": "好的，您可以大概说下您目前大致的情况吗？比如在读学历、专业、成绩等，我们可以给您留学规划跟匹配院校",
            "alternative":1,
            "current":"问题二"
        }];
    } catch (e) {
        if (!eventObj.outputForResponse) {
            eventObj.outputForResponse = {};
        }
        eventObj.outputForResponse.htmlText = [e];
    } finally {
        var eventResult = JSON.stringify(eventObj);
        return eventResult
    }
};