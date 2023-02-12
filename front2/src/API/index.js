import axios from 'axios'

//axios 인스턴스 생성
// const BASE_URL = "http://localhost:8080/data/"
const BASE_URL = "http://3.35.179.46:8080/data/"

const axiosAPI = (url, options) => {
  const instance = axios.create({ baseURL: url, 
    headers: {
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://3.35.179.46:3000'
    }
  , ...options })

  return instance
}

export const defaultInstance = axiosAPI(BASE_URL)
