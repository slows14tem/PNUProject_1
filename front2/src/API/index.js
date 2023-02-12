import axios from 'axios'

//axios 인스턴스 생성
// const BASE_URL = "http://localhost:8080/data/"
const BASE_URL = "http://3.35.179.46:8080/data/"

const axiosAPI = (url, options) => {
  const instance = axios.create({ baseURL: url, ...options })
  // instance.defaults.withCredentials = true;
  instance.defaults.headers = { 'Access-Control-Allow-Origin': '*'}

  return instance
}

export const defaultInstance = axiosAPI(BASE_URL)