# kotlinformaximo7
配置好 ant 环境变量 和 dunanmaximo.bat 中的 jdk1.7路径

将jar依赖包放置 maximolib 目录中

双击 dunanmaximo.bat 进行编译
编译之后的类位于 maximobin里面,复制到 maximo.ear 服务对应路径即可

maximo服务中需要引入kotlin依赖包

将lib/kotlin-runtime.jar 复制到 maximo.ear/lib 目录里
然后编辑 maximo.ear/businessobjects.jar 中的 META-INF/MANIFEST.MF 
添加 lib/kotlin-runtime.jar 保存后即可



