import React, {
    useState
} from 'react';

const FileUpload = ({
    onFileUpload
}) => {
    const [selectedFile, setSelectedFile] = useState(null);

    const handleFileChange = (e) => {
        const file = e.target.files[0];
        setSelectedFile(file);
    };

    const handleFileUpload = () => {
        onFileUpload(selectedFile);
    };

    return ( <div>
        <input type ="file" onChange = {
            handleFileChange
        }
        /> {
        selectedFile && < button onClick = {
            handleFileUpload
        } > Process </button>} </div>
    );
};

export default FileUpload;