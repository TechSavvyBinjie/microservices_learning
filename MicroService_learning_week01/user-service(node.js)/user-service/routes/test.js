const express = require("express");
const router = express.Router();
const {
  getAccount,
  insertAccount,
  updateAccount,
  deleteAccount,
} = require("../dataBase/api");
router.get("/list", (req, res) => {
  getAccount().then((response) => {
    res.send(response);
  });
});
router.post("/add", (req, res) => {
  let param = req.body;
  insertAccount(param).then((response) => {
    res.send(response);
  });
});
router.post("/update", (req, res, next) => {
  let param = req.body;
  updateAccount(param).then((response) => {
    res.send(response);
  });
});

router.get("/delete", (req, res, next) => {
  let id = req.query.id;
  deleteAccount([id]).then((response) => {
    res.send(response);
  });
});

module.exports = router;
