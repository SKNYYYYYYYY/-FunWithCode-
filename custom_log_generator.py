input {  file {    path => "/tmp/custom.log"    start_position => "beginning"    sincedb_path => "/dev/null"}} filter {  grok {    match => { "message" => "%{TIMESTAMP_ISO8601:timestamp} \| %{LOGLEVEL:log_level} \| %{GREEDYDATA:log_message}" }  }output {  elasticsearch {    hosts => ["http://172.19.98.14:9200"]    user => "elastic"      password => "Q_qWG7r*kYTz+DPenG9j
"}
