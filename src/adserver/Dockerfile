FROM golang:1.16-alpine

WORKDIR /app

COPY src/adserver/go.mod ./

COPY src/adserver/* ./

RUN go build

ENTRYPOINT [ "./adserver" ]
