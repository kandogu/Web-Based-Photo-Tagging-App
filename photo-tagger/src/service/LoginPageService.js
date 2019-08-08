import axios from 'axios'

const LoginPageService = {

    login(username){
        return axios.get("http://localhost:8086/api/login?userName=" + username)
    }
}
export default LoginPageService
