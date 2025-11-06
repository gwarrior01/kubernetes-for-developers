helm install postgresql ./postgresql -n petclinic


postgresql:
enabled: true
fullnameOverride: postgresql
auth:
enablePostgresUser: false
volumePermissions:
enabled: true
primary:
podSecurityContext:
enabled: true
fsGroup: 1001
containerSecurityContext:
enabled: true
runAsUser: 1001
runAsNonRoot: true
persistence:
enabled: true
size: 8Gi
extendedConfiguration: |
max_connections = 100
shared_buffers = 1GB
effective_cache_size = 3GB
maintenance_work_mem = 256MB
checkpoint_completion_target = 0.9
wal_buffers = 16MB
default_statistics_target = 100
random_page_cost = 1.1
effective_io_concurrency = 200
work_mem = 5242kB
huge_pages = off
min_wal_size = 1GB
max_wal_size = 4GB