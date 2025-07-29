# Запустить контейнер с сетевыми утилитами
# Используйте этот контейнер для диагностики сетевых проблем
```bash
kubectl run -it --image=amouat/network-utils --attach network-utils -- /bin/bash
```


```bash
kubectl describe pods timeserver-7b858b4bc7-4qcxs | grep IP: \
 && kubectl describe pods timeserver-7b858b4bc7-5cd28 | grep IP: \
  && kubectl describe pods timeserver-7b858b4bc7-nqkfx | grep IP:
```

```bash
kubectl get pods \
  --no-headers \
  -o custom-columns="NAME:.metadata.name,IP:.status.podIP" \
  | awk '$1 ~ /^timeserver/ {print $1 " -> " $2}'
```

```bash
curl $TIMESERVER_ENDPOINT/name && echo
```

timeserver-7b858b4bc7-2zjnz -> 10.1.0.181
timeserver-7b858b4bc7-8hq9b -> 10.1.0.182
timeserver-7b858b4bc7-n2hr7 -> 10.1.0.183



