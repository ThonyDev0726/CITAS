'use strict';

var myWidget = cloudinary.createUploadWidget({
    cloudName: 'dtzp3trnp',
    uploadPreset: 'preset_ant'}, (error, result) => {
    if (!error && result && result.event === "success") {
        console.log('Done! Here is the image info: ', result.info);
        document.getElementById('tag-id').innerHTML = result.info.secure_url;
        const imagen = document.querySelector('#imagen_bd');
        imagen.src = result.info.secure_url;
    }
});

document.getElementById("upload_widget").addEventListener("click", function () {
    myWidget.open();
}, false);