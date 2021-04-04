FROM alpine:3.13 AS build

RUN apk add openjdk11 --no-cache


WORKDIR /build
ADD . .
RUN ./scripts/build.sh

FROM alpine:3.13 AS runtime
RUN apk add openjdk11-jre --no-cache
WORKDIR /app
ADD scripts/entryPoint.sh /app/entryPoint.sh
ADD scripts/run.sh /app/run.sh

ENTRYPOINT [ "/app/entryPoint.sh" ]