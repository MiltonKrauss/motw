<template>
  <div class="completed-char">
    <div id="ban-message" role="alert" v-if="showError">
      {{ errorMessage }}
    </div>
    <div v-if="!showError">
      
      <character-creation-form v-if="!characterCreated" />
      <character-view-detailed v-if="characterCreated" />
    </div>
  </div>
</template>

<script>
import CharacterViewDetailed from "../components/CharacterViewDetailed.vue";
import CharacterCreationForm from "../components/CharacterCreationForm.vue";

export default {
  name: "character-view",

  data() {
    return {
      showError: false,
      errorMessage: "Sorry, You have been banned.",
    };
  },

  components: {
    CharacterViewDetailed,
    CharacterCreationForm,
  },
  computed: {
    characterCreated() {
      let created = Object.keys(this.$store.state.userCharacter).length !== 0;
      if (created) {
        created = this.$store.state.userCharacter.name !== "";
      }

      return created;
    },
  },

  methods: {
    showBanMessage() {
      if (this.$store.state.user.authorities[0].name === "ROLE_BAN") {
        this.showError = true;
      }
    },
  },

  created() {
    this.showBanMessage();
  },
};
</script>

<style scoped>

body {
  background-color: #3a5268;
}

#addHomeForm {
  background-color: #3a5268;
}

.completed-char {
  background-color: #3a5268;
}

#ban-message {
  height: 100%;
  text-align: center;
  font-size: 50px;
  font-weight: bold;
  color: #00e88a;
  background: #00201e;
}

</style>
