#!/usr/bin/env bash

if [ -n "$1" ]
then
echo "EXPECTING Config Service at $1 \n"

curl -X PUT -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: d2da1684-e9e7-af14-f551-9ef870726e4f"
-d '{ "data":"DummyData" }' "http://$1/testing_endpoint"

else
    echo "PROVIDE service hostname and RUN as below"
    echo "sh test.sh localhost:8080"
fi

