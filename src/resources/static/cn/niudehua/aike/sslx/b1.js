//问题一函数节点

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
            "content": "您好？您好！我是顺顺留学李老师，数据显示您在关注出国留学的信息， 您对哪个国家的留学信息比较感兴趣呢？咱们给您评估一下",
            "alternative":1,
            "current":"问题一"
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