function main(event) {
    try {
        var events = JSON.parse(event);
        var env = events.environment;
        var currentIntent = "问题4-其他建议";
        var slot = events.slotSummary;
        var prevIntent;
        var alternative;

        if (env.VENDOR_PARAM) {
            var param = JSON.parse(env.VENDOR_PARAM);
            alternative = param.alternative;
            prevIntent = param.current;
        }
        if(slot["网络状况.zk"]!=""){
            events.routeVariable="防误入"
        } else {
            event.routeVariable="正常流程"
            events.outputForResponse.htmlText = [{
                "interruptible": "true",
                "content": "请问您对我们还有什么意见或建议？",
                "alternative": "1",
                "current": currentIntent,
                "procedures": [{
                    "name": "summarize",
                    "params": "{\"category\":{'category':'网络问题调研'},\"name\":\"目前状况\", \"content\":\""+slot["网络状况.zk"]+"\"}"
                }],
                "variables": {
                    "timeout": "1"
                }
            }];
        }
        return events;
    } catch (e) {
        return e;
    }
}