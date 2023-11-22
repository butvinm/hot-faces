# Hot Faces

Jakarta Server Faces application with JSF files uploaded "on-fly" from MongoDB.

That feature utilize `ResourceHandlerWrapper` and mocked `Resource` class from Mojarra source code to provide JSF from MongoDB storage. Uploaded files stored at `/temp` folder and updated automatically on each new request.

In that example you can run application, copy `index.xhtml` to the text area on web page and you would get same page, but stored in the database. Than, you can got to that page, copy paste it to itself, update content and after page reload you would notice page changes.

## About `standalone.sh`

In the repository ypu can find `standalone.sh` file that is copied into container during build process. That file is patched version of Wildfly starter and used to enable suspending until remote debugger connection. `suspend=y` property of JVM is set up to achieve that (essentially, the `standalone.xml` config file could be modified, but that was just easier for me.)

For running your application in Docker and connect it to VSCode debugger, follow those steps:

1. Build container with `./standalone.sh` included instead of original `/opt/jboss/wildfly/bin/standalone.sh` file
2. Add following task to your `./.vscode/launch.json` file:
```json
{
    "type": "java",
    "name": "Debug (Attach)",
    "projectName": "MyProjectName",
    "request": "attach",
    "hostName": "127.0.0.1",
    "port": 8787,
}
```
3. Set `/opt/jboss/wildfly/bin/standalone.sh --debug -b 0.0.0.0` command as container entrypoint or just call `docker run <your image> /opt/jboss/wildfly/bin/standalone.sh --debug -b 0.0.0.0`.
4. Wait, until Java will start and stop waiting debugger connection. Then start debug session in VSCode and Wildfly should start.

For that project you can just run `make`, always is already set up.
