import React from 'react';
import axios from 'axios';

class NoteModal extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            title: this.props.notes.title,
            content: this.props.notes.content,
            id: this.props.notes.id,
        }
        console.log(this.state.id)
    }

    submitHandler = (e) => {
        const note = {
            title: this.state.title,
            content: this.state.content,
            id: this.state.id
        }
        axios.put('/notes/${id}', note).then(response => {
            (response)
        }).catch(error => {
            (error)
        })
    }

    deleteHandler = (e) => {
        axios.delete(`/notes/${this.state.id}`).then(response => {
            (response)
        }).catch(error => {
            (error)
        })
    }

    render() {
        const {notes} = this.props
        return (
            <div>{notes && (
                <div className="modal-backdrop"
                     id="modalBox"
                >
                    <div className="modal"
                         role="dialog"
                         aria-labelledby="modalTitle"
                         aria-describedby="modalContent"
                    >
                        <form className="edit-form" onSubmit={this.submitHandler}>
                            <input
                                id="modalTitle"
                                onChange={(text) => {
                                    this.setState({title: text.target.value})
                                }}
                                name="title"
                                placeholder="Title"
                                value={this.state.title}
                            />
                            <textarea
                                id="modalContent"
                                onChange={(text) => {
                                    this.setState({content: text.target.value})
                                }}
                                name="content"
                                placeholder="Note..."
                                rows="8"
                                value={this.state.content}
                            />
                            <footer className="modal-footer">
                                <button
                                    onClick={this.deleteHandler}
                                    type="button"
                                    className="modal-button">
                                    <span>Delete</span>
                                </button>
                                <button type="submit" className="modal-button">
                                    <span>Close</span>
                                </button>
                            </footer>
                        </form>
                    </div>
                </div>
            )}
            </div>
        )
    }
}

export default NoteModal