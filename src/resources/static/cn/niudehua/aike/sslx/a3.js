//问题三函数节点

function main(event) {
    try {
        var events = JSON.parse(event);
        var env = events.environment;
        var slot = events.slotSummary;
        var currentIntent ="问题3";
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
                "content": "抱歉，我没听清，请问您目前是什么学历在读呢？高中？本科？研究生？还是已经在职了呢？",
                "alternative": "2",
                "current":currentIntent,
                "procedures":[{
                    "name":"summarize",
                    "params":"{\"category\":{'category':'顺顺留学'},\"name\":\"顺顺留学-问题3\", \"content\":\"拒识一次\"}"
                }]
            }];
        }
        else if (alternative == "2" && prevIntent == currentIntent) {
            events.routeVariable = "拒识两次";
        }
        else{
            events.outputForResponse.htmlText = [{
                "content":"好的。那请问您目前是什么学历在读呢？高中？本科？研究生？还是已经在职了呢？",
                "alternative": "1",
                "current":currentIntent,
                "procedures":[{
                    "name":"summarize",
                    "params":"{\"category\":{'category':'顺顺留学'},\"name\":\"顺顺留学-问题3\", \"content\":\""+slot["问题三触发.targetXueli"]+"\"}"
                }]
            }];
        }
        return events;
    }catch (e) {
        return e;
    }
}