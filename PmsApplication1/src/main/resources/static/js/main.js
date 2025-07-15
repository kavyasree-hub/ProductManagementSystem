const api = '/api';
const itemsEl = document.getElementById('items');
const cartBody = document.querySelector('#cartTable tbody');

function loadItems(cat) {
  axios.get(`${api}/items/${cat}`).then(res => {
    itemsEl.innerHTML = res.data.map(renderCard).join('');
  });
}

function renderCard(item) {
  return `<div class="col">
    <div class="card h-100">
      <img src="${item.imageUrl}" class="card-img-top" alt="${item.name}" />
      <div class="card-body d-flex flex-column">
        <h5 class="card-title">${item.name} - ₹${item.price}</h5>
        <button class="btn btn-primary mt-auto" onclick="addToCart(${item.id})">Add</button>
      </div>
    </div>
  </div>`;
}

function addToCart(id) {
  axios.post(`${api}/cart/${id}`).then(refreshCart);
}

function removeFromCart(id) {
  axios.delete(`${api}/cart/${id}`).then(refreshCart);
}

function refreshCart() {
  axios.get(`${api}/cart`).then(res => {
    let total = 0;
    cartBody.innerHTML = res.data.map(ci => {
      const sub = ci.price * ci.quantity;
      total += sub;
      return `<tr>
        <td>${ci.name}</td>
        <td>${ci.quantity}</td>
        <td>₹${ci.price}</td>
        <td>₹${sub}</td>
        <td><button class="btn btn-sm btn-danger" onclick="removeFromCart(${ci.itemId})">Delete</button></td>
      </tr>`;
    }).join('');
    cartBody.innerHTML += `<tr class="table-secondary">
      <td colspan="3"><strong>Total</strong></td>
      <td colspan="2"><strong>₹${total}</strong></td>
    </tr>`;
  });
}

Array.from(document.querySelectorAll('#categoryTabs button')).forEach(btn => {
  btn.addEventListener('click', e => {
    Array.from(document.querySelectorAll('#categoryTabs .nav-link')).forEach(b => b.classList.remove('active'));
    e.target.classList.add('active');
    loadItems(e.target.dataset.cat);
  });
});

loadItems('groceries');
refreshCart();