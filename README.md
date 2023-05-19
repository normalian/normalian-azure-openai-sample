# normalian-azure-openai-sample
This sample enable you to have quick start for Azure OPEN AI with Java code. 

## Prerequisite 
First, setup up Azure Environment 
- Acquire Azure subscription. Try free trial accoutn https://azure.microsoft.com/en-us/free/
- Enale Azure Open AI on your Azure subscription https://customervoice.microsoft.com/Pages/ResponsePage.aspx?id=v4j5cvGGr0GRqy180BHbR7en2Ais5pxKtso_Pz4b1_xUOFA5Qk1UWDRBMjg0WFhPMkIzTzhKQ1dWNyQlQCN0PWcu
- Create Azure Open AI deploument from GPT-3 models https://learn.microsoft.com/en-us/azure/cognitive-services/openai/concepts/models 

Second, setup up Java environment on your machine.
- Install JDK 18+
- Install Gradle
- Install Visual Studio Code

## How to run this sample
Update AOAI_DEPLOYMENT_NAME, AOAI_BASE_URL, and AOAI_API_KEY variables with your environment values. 
```
    "configurations": [
        {
            "type": "java",
            "name": "ConsumingRestApplication",
            "request": "launch",
            "mainClass": "xyz.normalian.example.ChatCompletionApplication",
            "projectName": "aoai-normalian-sample",
            "env": {
                "AOAI_DEPLOYMENT_NAME": "INPUT YOUR Azure OPEN AI DEPLOYMENT NAME",
                "AOAI_BASE_URL" : "INPUT YOUR Azure OPEN AI BASE URL - https://xxxxxxxxx.openai.azure.com",
                "AOAI_API_KEY" : "INPUT YOUR Azure OPEN AI API KEY"
            }
        }
    ],
```

## References
- https://github.com/actions/setup-java
- https://qiita.com/kaburankattara/items/27a3891512ad2bd935a9
- https://blackbird-blog.com/vsc-springboot-start
