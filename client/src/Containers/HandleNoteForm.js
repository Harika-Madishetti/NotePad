import React from 'react';
import NoteForm from "../Components/NoteForm";
import axios from "axios/index";

class HandleNoteForm extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            title: '',
            content: '',
            titleFieldVisible: false,
        }
    }

    handleSubmit = (e) => {
        e.preventDefault()
        if (this.state.title || this.state.content) {
            return axios
                .post('http://localhost:8080/notes/', this.state)
                .then(response => {
                    (response)
                })
                .catch(error => {
                    (error)
                })
        }
    }
    hideTitleField = () => {
        this.setState({
            titleFieldVisible: false
        })
    }

    showTitleField = () => {
        this.setState({
            titleFieldVisible: true
        })
    }
    handleChange = (text) => {
        this.setState({[text.target.name]: text.target.value})
    }

    render() {
        let props = {
            title: this.state.title,
            content: this.state.content,
            titleFieldVisible: this.state.titleFieldVisible
        }
        return (
            <NoteForm {...props} handleSubmit={this.handleSubmit} handleTitleField={this.hideTitleField}
                      showTitleField={this.showTitleField} handleChange={this.handleChange}/>
        )
    }
}

export default HandleNoteForm;