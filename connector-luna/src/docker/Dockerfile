ARG LUNA_VERSION
FROM datastax/lunastreaming:${LUNA_VERSION}
ARG BUILD_VERSION
COPY luna-cassandra-source-${BUILD_VERSION}.nar /pulsar/connectors/
COPY pulsar-io-elastic-search-2.7.2.1.1.6.nar /pulsar/connectors/
