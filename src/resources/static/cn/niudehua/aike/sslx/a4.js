//问题四函数节点

function main(event) {
    try {
        var events = JSON.parse(event);
        var env = events.environment;
        var slot = events.slotSummary;
        var currentIntent ="问题4";
        var prevIntent;
        var alternative;
        events.routeVariable = "正常流程";

        if (env.VENDOR_PARAM){
            var param = JSON.parse(env.VENDOR_PARAM);
            alternative = param.alternative;
            prevIntent = param.current;
        }

        if(alternative == "1" && prevIntent == currentIntent){
            events.outputForResponse.htmlText = [{
                "content": "抱歉，我没听清，您这边、有准备雅思、或者、托福了吗？",
                "alternative": "2",
                "current":currentIntent,
                "procedures":[{
                    "name":"summarize",
                    "params":"{\"category\":{'category':'顺顺留学'},\"name\":\"顺顺留学-问题4\", \"content\":\"拒识一次\"}"
                }]
            }];
        }
        else if (alternative == "2" && prevIntent == currentIntent) {
            events.routeVariable = "拒识两次";


        }
        else{
            events.outputForResponse.htmlText = [{
                "content":"好的，出国留学需要语言成绩的，雅思、托福、您这边有准备了吗？",
                "alternative": "1",
                "current":currentIntent,
                "procedures":[{
                    "name":"summarize",
                    "params":"{\"category\":{'category':'顺顺留学'},\"name\":\"顺顺留学-问题4\", \"content\":\""+slot["问题三触发.targetXueli"]+"\"}"
                }]
            }];
        }
        return events;
    }catch (e) {
        return e;
    }
}