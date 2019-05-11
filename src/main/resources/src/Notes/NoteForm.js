import React from 'react';
import axios from 'axios';
import NoteBox from "./NoteBox";

class NoteForm extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            title: '',
            content: '',
            titleFieldVisible: false,
        }
    }

    handleSubmit = () => {
        if (this.state.title || this.state.content) {
            axios
                .post('/notes/', this.state)
                .then(response => {
                    <NoteBox/>
                })
                .catch(error => {
                    (error)
                })
        }
        this.setState({
            title: '',
            content: '',
            titleFieldVisible: false,
        })
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
        return (
            <div>
                <div className="create-form">
                    {this.state.titleFieldVisible && (
                        <div className="backdrop" onClick={this.hideTitleField}>
                        </div>
                    )}

                    <form onSubmit={this.handleSubmit} className="create-note">
                        {this.state.titleFieldVisible && (
                            <input
                                name="title"
                                type="text"
                                value={this.state.title}
                                onChange={this.handleChange}
                                onFocus={this.showTitleField}
                                placeholder="Title"/>
                        )}
                        <textarea
                            name="content"
                            value={this.state.content}
                            onChange={this.handleChange}
                            onFocus={this.showTitleField}
                            placeholder="Take a note"
                        />
                        <button type="Submit">
                            <span>&#43;</span>
                        </button>
                    </form>
                </div>
            </div>
        )
    }
}

export default NoteForm;