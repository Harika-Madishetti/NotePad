import axios from 'axios';

export const getNotes =  () => {
    return new Promise(function (resolve, reject) {
        try{
            axios.get('http://localhost:8080/notes/').then(response => {
                resolve(response.data)
            })
        }catch (e) {
            reject(e)
        }
    })
}

export const delNotes = (id) => {
    return new Promise(function (resolve,reject) {
        try{
             axios.delete(`http://localhost:8080/notes/${id}`).then(response => {
                resolve(response)
            })
        }catch (e) {
            console.log(reject(e))
            reject(e)
        }
    })
}