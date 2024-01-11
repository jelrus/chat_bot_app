<script>
import axios from "axios";

export default {
    name: 'ChatBot',
    data() {
        return {
            masterImg: require("../assets/master.svg"),
            slaveImg: require("../assets/slave.svg"),
            requestId: 1,
            reqText: '',
            request: null,
            responses: [],
            response: null
        };
    },
    mounted() {
        this.getRequest();
    },
    methods: {
        getRequest() {
            axios.get('http://localhost:8080/request/' + this.requestId)
                .then(response => {
                    this.request = response.data;
                    this.reqText = response.data.reqText;
                    this.responses = response.data.responses;
                })
                .catch(error => {
                    console.error('Error fetching data:', error);
                });
        },
        getResponse(id) {
            axios.get('http://localhost:8080/response/' + id)
                .then(response => {
                    this.response = response.data;
                    this.removeRequests();
                    this.renderRequest();
                    this.renderResponse();
                    this.renderAnotherRequest();
                    this.scrollToBottom();
                })
                .catch(error => {
                    console.error('Error fetching data:', error);
                });
        },
        removeRequests() {
            const buttons = document.getElementById("resp-buttons");
            buttons.remove();
        },
        renderRequest() {
            const rootElement = document.getElementById("chat-dialog");

            const responseElement = document.createElement("div");
            responseElement.className = "respReply";

            const slaveImage = document.createElement("img");
            slaveImage.className = "slaveImage";
            slaveImage.src = this.slaveImg;

            const responseElementSpan = document.createElement("span");
            responseElementSpan.textContent = this.response.option;

            responseElement.appendChild(responseElementSpan);
            responseElement.appendChild(slaveImage);
            rootElement.appendChild(responseElement);
        },
        renderResponse() {
            const rootElement = document.getElementById("chat-dialog");

            const reqWrapper = document.createElement("div");
            reqWrapper.className = "reqWrapper";

            const imageWrapper = document.createElement("div");
            imageWrapper.className = "imageWrapper";

            const masterImage = document.createElement("img");
            masterImage.className = "masterImage";
            masterImage.src = this.masterImg;

            const responseElement = document.createElement("div");
            responseElement.className = "reqText";

            const responseElementSpan = document.createElement("span");
            responseElementSpan.textContent = this.response.respText;

            reqWrapper.appendChild(imageWrapper);
            imageWrapper.appendChild(masterImage);
            reqWrapper.appendChild(responseElement);
            responseElement.appendChild(responseElementSpan);
            rootElement.appendChild(reqWrapper);
        },
        renderAnotherRequest() {
            const rootElement = document.getElementById("chat-dialog");

            const reqWrapper = document.createElement("div");
            reqWrapper.className = "reqWrapper";

            const imageWrapper = document.createElement("div");
            imageWrapper.className = "imageWrapper";

            const masterImage = document.createElement("img");
            masterImage.className = "masterImage";
            masterImage.src = this.masterImg;

            const requestElement = document.createElement("div");
            requestElement.className = "reqText";
            requestElement.textContent = "Что еще могу сделать?"

            reqWrapper.appendChild(imageWrapper);
            imageWrapper.appendChild(masterImage);
            reqWrapper.appendChild(requestElement);
            rootElement.appendChild(reqWrapper);

            const listElement = document.createElement("ul");
            listElement.className = "respButtons";
            listElement.id = "resp-buttons";

            for (let i = 0; i < this.request.responses.length; i++) {
                const listOption = document.createElement("li");
                listOption.className = "respButtonWrapper";

                const respButton = document.createElement("button");
                respButton.className = "respButton";
                respButton.onclick = () => this.getResponse(this.responses[i].id);

                const buttonsSpan = document.createElement("span");
                buttonsSpan.textContent = this.request.responses[i].option;


                respButton.appendChild(buttonsSpan);
                listOption.appendChild(respButton);
                listElement.appendChild(listOption);
            }

            rootElement.appendChild(listElement);
        },
        scrollToBottom() {
            const chatWindow = document.getElementById("chat-dialog-wrapper");
            chatWindow.scrollTop = chatWindow.scrollHeight;
        }
    }
}
</script>

<template>
    <div class="reqWrapper">
        <div class="imageWrapper">
            <img class="masterImage" src="../assets/master.svg" alt="">
        </div>
        <div class="reqText">
            {{ reqText }}
        </div>
    </div>
    <ul id="resp-buttons" class="respButtons">
        <li class="respButtonWrapper" v-for="(item, index) in responses" :key="index">
            <button class="respButton" @click="getResponse(item.id)">
                <span>{{ item.option }}</span>
            </button>
        </li>
    </ul>
</template>

<style>
.reqWrapper {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
}

.imageWrapper {
    width: fit-content;
    height: fit-content;
    display: flex;
    flex-direction: row;
    align-items: center;
    margin: 2.5% 0 0;
    padding-right: 2%;
}

.masterImage {
    height: 40px;
    width: 40px;
    border: 0 solid transparent;
    background-color: white;
    padding: 10px;
    border-top-left-radius: 15px;
    border-bottom-left-radius: 15px;
    border-top-right-radius: 15px;
    box-shadow: 0 0 3px #ccc;
}

.slaveImage {
    height: 40px;
    width: 40px;
    border: 0 solid transparent;
    background-color: white;
    padding: 10px;
    border-top-left-radius: 15px;
    border-bottom-right-radius: 15px;
    border-top-right-radius: 15px;
    box-shadow: 0 0 3px #ccc;
}

.reqText {
    font-family: Arial, serif;
    font-size: small;
    color: white;
    background-color: rgb(110, 72, 170);
    padding: 5%;
    border: 0 solid transparent;
    border-top-left-radius: 15px;
    border-bottom-right-radius: 15px;
    border-top-right-radius: 15px;
    margin: 2.5% 0 0;
    width: fit-content;
}

.respButtons {
    margin: 0;
    padding: 2.5% 0 2.5%;
    display: flex;
    flex-direction: column;
    align-items: flex-end;
}

.respButtonWrapper {
    display: flex;
    width: fit-content;
    padding: 1% 0;
    border: 0 solid transparent;
}

.respButton {
    font-family: Arial, serif;
    font-size: small;
    color: white;
    background-color: rgb(75, 72, 170);
    border: 0 solid transparent;
    display: flex;
    flex-direction: column;
    width: fit-content;
    height: 100%;
    align-items: center;
    border-top-left-radius: 15px;
    border-bottom-left-radius: 15px;
    border-top-right-radius: 15px;
}

.respButton span {
    display: flex;
    width: 100%;
    height: fit-content;
    padding: 15px;
    align-items: center;
    justify-content: center;
}

.respButton:hover {
    opacity: 0.8;
}

.respReply {
    display: flex;
    width: 100%;
    height: 100%;
    align-items: center;
    justify-content: flex-end;
    margin: 0;
    padding-top: 2.5%;
}

.respReply span {
    font-family: Arial, serif;
    font-size: small;
    color: black;
    background-color: white;
    display: flex;
    width: fit-content;
    height: fit-content;
    padding: 8%;
    border: 0 solid transparent;
    border-top-left-radius: 15px;
    border-bottom-left-radius: 15px;
    border-top-right-radius: 15px;
    box-shadow: 0 0 3px #ccc;
    margin-right: 2%;
}
</style>