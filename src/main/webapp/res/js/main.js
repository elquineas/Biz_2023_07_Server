const err_massage = (e, err_box, message) => {
  const value = e.value;
  if (!value || value === "0") {
    err_box.classList.add("on");
    err_box.innerHTML = message;
    // e.select();
    return false;
  }
  return true;
};
