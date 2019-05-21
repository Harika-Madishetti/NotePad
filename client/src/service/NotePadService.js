import axios from 'axios';

export const getNotes = () => {
    return new Promise(function (resolve, reject) {
        try {
            axios.get('http://localhost:8080/notes/').then(response => {
                resolve(response.data)
            })
        } catch (e) {
            reject(e)
        }
    })
}

export const modifyNotes = (note, id) => {
    return new Promise(function (resolve, reject) {
        try {
            axios.put(`http://localhost:8080/notes/${id}`, note).then(response => {
                resolve(response)
            })
        } catch (e) {
            reject(e)
        }
    })
}

export const delNotes = (id) => {
    return new Promise(function (resolve, reject) {
        try {
            axios.delete(`http://localhost:8080/notes/${id}`).then(response => {
                resolve(response)
            })
        } catch (e) {
            reject(e)
        }
    })
}
