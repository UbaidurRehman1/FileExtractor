<h3 align="center">File Extractor .tgz</h3>
<ol>
	<h4>About</h4>
	<li>Build it inside the folder where you want to extract all files</li>
	<li>Simply run it, it will extract all .tgz only files and after extracting, it automatically delete them</li>
	<li>You can simply change source code, to no delete or change file filter as well</li>
</ol>
<ol>
	<h4>Building Instruction</h4>
	Do the following steps
	<li><strong>git clone 'https://github.com/UbaidurRehman1/FileExtractor.git'</strong></li>
	<li><strong>cd FileExtractor</strong></li>
	<li><strong>mvn clean compile assembly:single</strong></li>
	<li>after success full build copy the FileExtractor-1-jar-with-dependencies.jar to the folder where .tgz files exists</li>
	<li><strong>java -jar FileExtractor-1-jar-with-dependencies.jar</strong> to run the jar</li>
</ol>
<ol>
	<h4>Requirements</h4>
	<li>Java JDK > 8</li>
	<li>Apache MAVEN</li>
	<li>set JAVA_HOME variable (optional)</li>
	<li>set MAVEN_HOME (optional)</li>
</ol>