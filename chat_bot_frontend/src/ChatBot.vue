<template>
    <div id="app" class="app">
        <div id="chat-dialog-wrapper" class="chatDialogWrapper">
            <div id="chat-dialog" class="chatDialog">
                <chat-bot-messaging/>
            </div>
        </div>
    </div>
</template>

<script>

import {defineComponent} from "vue";
import ChatBotMessaging from "@/components/ChatBotMessaging.vue";

export default defineComponent({
    name: "ChatBot",
    components: {ChatBotMessaging}
})

</script>

<style>

body {
    background-color: #202020;
    margin: 0;
    padding: 0;
    height: 100vh;
    width: 100vw;
    display: block;
}

.app {
    display: flex;
}

.chatDialogWrapper {
    position: absolute;
    bottom: 2%;
    right: 40%;
    background-color: white;
    width: 300px;
    height: 420px;
    border: 0 solid transparent;
    border-radius: 0.75vw;
    padding: 1%;
    overflow-y: auto;
}

.chatDialog {
    width: 100%;
    height: fit-content;
    display: flex;
    flex-direction: column;
}
</style>
