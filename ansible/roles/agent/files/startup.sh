#!/bin/bash
SECRET=$(cat $HOME_DIR/agent_secret_token.txt)
exec /usr/bin/java -jar $JAR_PATH -url $API_URL -name $AGENT_NAME -secret $SECRET -webSocket -workDir $HOME_DIR