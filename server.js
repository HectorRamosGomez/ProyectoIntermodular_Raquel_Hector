const express = require('express');
const app = express();
app.use(express.json());

app.post('/users/validate_unique_email', (req, res) => {
    const { email } = req.body;
    console.log("Validando email local:", email);
    if (email === "test@gmail.com") {
        return res.status(400).json({ isUnique: false });
    }
    res.status(200).json({ isUnique: true });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Servidor funcionando en el puerto ${PORT}`));
