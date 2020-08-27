import React from 'react'

import Modal from 'react-modal'

export default function ModalCpt({
    isOpen,
    children,
    closeModal,
    modalIsOpen,
    afterOpenModal
}) {

    const customStyles = {
        overlay: {
            background:"rgba(61,57,63,0.71)"
        },
        content: {
            top: '50%',
            left: '50%',
            right: 'auto',
            bottom: 'auto',
            marginRight: '-50%',
            transform: 'translate(-50%, -50%)',
            maxHeight: "80%"
        }
    };

    return (
        <Modal
            isOpen={isOpen}
            onAfterOpen={afterOpenModal}
            onRequestClose={closeModal}
            contentLabel="Example Modal"
            style={customStyles}
            
        >
            {children}
        </Modal>
    )
}