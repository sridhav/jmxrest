SHELL := /bin/bash 

mybatis-gen:
	rm -rf src/main/resources/com/github/sridhav/jmxrest/mybatis/mapper
	rm -rf src/main/java/com/github/sridhav/jmxrest/mybatis/mapper
	rm -rf src/main/java/com/github/sridhav/jmxrest/mybatis/entity
	mvn mybatis-generator:generate -pl mybatis
