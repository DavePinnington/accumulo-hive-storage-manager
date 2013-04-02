add jar /opt/cloud/accumulo-trunk/trunk/lib/commons-collections-3.2.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/commons-configuration-1.5.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/commons-io-1.4.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/commons-lang-2.4.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/commons-logging-1.0.4.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/commons-vfs2-2.0.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/jline-0.9.94.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/accumulo-trace-1.6.0-SNAPSHOT.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/accumulo-fate-1.6.0-SNAPSHOT.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/accumulo-core-1.6.0-SNAPSHOT.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/accumulo-server-1.6.0-SNAPSHOT.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/accumulo-start-1.6.0-SNAPSHOT.jar;
add jar /opt/cloud/accumulo-trunk/trunk/lib/accumulo-hive-storage-handler-1.6.0-SNAPSHOT.jar;

DROP TABLE IF EXISTS test_table;
CREATE EXTERNAL TABLE test_table(blah STRING, value STRING) 
STORED BY 'org.apache.accumulo.storagehandler.AccumuloStorageHandler' 
WITH SERDEPROPERTIES ('accumulo.columns.mapping' = 'cf|f1', 
	'accumulo.key.mapping' = 'blah', 
	'accumulo.table.name' = 'foo'); 

select * from test_table;