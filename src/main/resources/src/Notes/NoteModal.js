import React from 'react';

class NoteModal extends React.Component {
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
                        <form className="edit-form">
                            <input
                                id="modalTitle"
                                name="title"
                                placeholder="Title"
                                value={notes.title}
                            />
                            <textarea
                                id="modalContent"
                                name="content"
                                placeholder="Note..."
                                rows="8"
                                value={notes.content}
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