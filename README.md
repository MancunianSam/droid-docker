# Droid in Docker

This is a proof of concept on running Droid in a docker container.

## Quick start
```shell
docker pull mancuniansam/droid-docker
docker run -v /path/to/your/files/:/tmp/files mancuniansam/droid-docker
```

## Building locally
```shell
mvn clean package assembly:single
docker build -t mancuniansam/droid-docker .
docker run -v /path/to/your/files/:/tmp/files mancuniansam/droid-docker
```

The call to docker run will output json with this structure

```json
[
  {
    "extension": "mp4",
    "method": "BINARY_SIGNATURE",
    "puid": "fmt/199",
    "name": "MPEG-4 Media File",
    "fileName": "file:///tmp/FileName"
  }
]
```
