# kotlinformaximo7

首先配置好 ant 环境变量 和 dunanmaximo.bat 中的 jdk1.7路径
#访问 http://shoukaiseki.blog.163.com/blog/static/192856149201757115031531/# 查看配置方案


配置完ant之后,将开发maximo需要的jar依赖包放置 maximolib 目录中  
1.businessobjects.jar 放入maximolib中
2.将 MAXIMO.ear/maximouiweb.war/WEB-INF/classes 打包成jar也放入maximolib中
(打包命令参考jarbeanbat/jarcleaases.bat,或者直接将该 jarbeanbat/jarcleaases.bat 文件放在 MAXIMO.ear/maximouiweb.war/WEB-INF 目录执行)


双击 dunanmaximo.bat 进行编译
编译之后的类位于 maximobin里面,复制到 maximo.ear 服务对应路径即可

maximo服务中需要引入kotlin依赖包

将lib/kotlin-runtime.jar 复制到 maximo.ear/lib 目录里
然后编辑 maximo.ear/businessobjects.jar 中的 META-INF/MANIFEST.MF 
添加 lib/kotlin-runtime.jar 保存后即可



