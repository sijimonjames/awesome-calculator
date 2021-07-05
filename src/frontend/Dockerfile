FROM node:12

# Create app directory
WORKDIR /usr/src/app

COPY src/frontend/package*.json ./
RUN npm install
COPY src/frontend/ ./

CMD [ "node", "index.js" ]
