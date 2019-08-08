import axios from 'axios'
const MainPageService  = {

    delete(userName){
        axios.delete("http://localhost:8086/api/delete/" + userName);
    },

    putTag(id, tag){
        return axios.put("http://localhost:8086/api/tag/" + id + "?Tag=" + tag)
    },

    getPic(userName){
        return axios.get("http://localhost:8086/api/main/" + userName)
    }
}
export default MainPageService
