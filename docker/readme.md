### what is running now
```shell
docker ps
```

### stop container
```shell
docker stop {container-name}
```

### start container (docker-compose.yaml) DON'T CLOSE
```shell
docker-compose up
```

### jump into container (pg_2)
```shell
docker exec -ti pg_2 bash
```

### inside container:

#### become postgres user
```shell
su postgres
```

#### create database (fs10)
```shell
createdb fs10
```

### exit from user postgres
```shell
exit
```

### exit from container
```shell
exit
```



