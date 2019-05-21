import axios from 'axios';

export const getNotes =  () => {
    return new Promise(function (resolve, reject) {
        console.log("promise")
        try{
            axios.get('http://localhost:8080/notes/').then(response => {
                resolve(response.data)
            })
        }catch (e) {
            reject(e)
        }
    })
}