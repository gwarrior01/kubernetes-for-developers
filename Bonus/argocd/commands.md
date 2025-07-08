Применить
kubectl create namespace argocd
kubectl apply -n argocd -f install.yaml

Пробросить порты
kubectl port-forward svc/argocd-server -n argocd 8888:443
Узнать пароль для пользователя admin
kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
