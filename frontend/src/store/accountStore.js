// import { requestLogin } from "../common/api/accountAPI";

const state = {
  token: null,
  id: null,
  password: null,
};

const getters = {
  getToken: (state) => {
    return state.token;
  },
  getId: (state) => {
    return state.id;
  },
  getPassword: (state) => {
    return state.password;
  },
};

const mutations = {
  setUserInfo: (state, loginData) => {
    state.id = loginData.id;
    state.password = loginData.password;
    state.token = loginData.token;
  },
};

const actions = {
  loginAction: ({ commit }, loginData) => {
    commit("setUserInfo", loginData);
  },
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
