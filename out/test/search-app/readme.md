### Search Classes App 




#### Plan and Task Breakdown

- Project Setup build artifact
- [ ] Create Project Build Directory  
``` bash
$ mkdir build-out
```
- [ ] Create Build Artifact Directory
``` bash
$ mkdir build-out/target
```
- [ ] Project Compile All Package
``` bash
  $ javac -cp target:./lib/junit-platform-console-standalone-1.8.1.jar  ./src/com/mikaelslab/*.java -d ./build-out/
```
- [ ] Project All Test Running 
``` bash
  $ java -jar ./lib/junit-platform-console-standalone-1.8.1.jar --class-path build-out  --scan-class-path
``` 
- [ ] Create Application Artifact Jar
``` bash
$ jar cvfm ./build-out/target/search-app-v1.0.0.jar ./src/META-INF/MANIFEST.MF -C ./build-out/ .
```
- [ ] Running Application Jar 
``` bash
$ java -jar ./build-out/target/search-app-v1.0.0.jar
```


- Prepare Functional code structure and unit test   

- Read File and Directory recursive 

- Search Algo Logic 
   - Filter Cases  

- Readme Me and Doc