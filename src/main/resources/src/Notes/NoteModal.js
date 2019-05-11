import React from 'react';

class NoteModal extends React.Component {
    state = {
        title: this.props.notes.title,
        content: this.props.notes.content
    }

    render() {
        const {notes} = this.props
        return (
            <div>{notes && (
                <div className="modal-backdrop"
                     id="modalBox">
                    <div className="modal"
                         role="dialog"
                         aria-labelledby="modalTitle"
                         aria-describedby="modalContent">
                        <form
                            className="edit-form"
                        >
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
                                    this.setState({content: text.target.content})
                                }}
                                name="content"
                                placeholder="Note..."
                                rows="8"
                                value={this.state.content}
                            />
                            <footer className="modal-footer">
                                <button
                                    type="button"
                                    className="delete-button"
                                >
                                </button>
                                <button type="submit" className="submit-button">
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