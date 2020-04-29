//问题四函数节点

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
            "content": "ok，了解，同学怎么称呼您呢？",
            "alternative": 1,
            "current": "问题四"
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