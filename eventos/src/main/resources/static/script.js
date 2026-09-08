// URLs das APIs
const apiEquipamento = \"/equipamento\";
const apiUsuario = \"/usuario\";
const apiMovimentacao = \"/movimentacao\";

// Controle de Abas
function abrirAba(nomeAba) {
    document.querySelectorAll('.conteudo-aba').forEach(aba => aba.style.display = 'none');
    document.querySelectorAll('.btn-aba').forEach(btn => btn.classList.remove('ativa'));
    
    document.getElementById(nomeAba).style.display = 'block';
    event.currentTarget.classList.add('ativa');
}


// ==========================================
// MÓDULO EQUIPAMENTO
// ==========================================
async function cadastrarEquipamento() {
    const novoRegistro = {
        marca: document.getElementById('equip_marca').value,
        modelo: document.getElementById('equip_modelo').value,
        categoria: document.getElementById('equip_categoria').value,
        potencia: parseInt(document.getElementById('equip_potencia').value) || 0,
        material: document.getElementById('equip_material').value,
        peso: parseInt(document.getElementById('equip_peso').value) || 0,
        dimensoes: parseInt(document.getElementById('equip_dimensoes').value) || 0,
        cor: document.getElementById('equip_cor').value,
        quantidade: parseInt(document.getElementById('equip_quantidade').value) || 0
    };

    try {
        const response = await fetch(${apiEquipamento}/salvar-equipamento, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(novoRegistro)
        });

        if (!response.ok) {
            alert(\"Erro ao cadastrar registro. Verifique os dados.\");
            return;
        }

        alert(\"Cadastro efetuado com sucesso!\");
        limparFormularioEquipamento();
    } catch (err) {
        console.error('Erro ao cadastrar registro:', err);
    }
}

async function pesquisarEquipamento() {
    const codigo = document.getElementById('equip_id').value;
    if (!codigo) {
        alert(\"Digite o código para consultar!\");
        return;
    }

    try {
        const response = await fetch(${apiEquipamento}/buscar-equipamento/);
        if (!response.ok) {
            alert(\"Registro não encontrado!\");
            return;
        }

        const registro = await response.json();
        if (registro && registro.id) {
            document.getElementById('equip_marca').value = registro.marca || '';
            document.getElementById('equip_modelo').value = registro.modelo || '';
            document.getElementById('equip_categoria').value = registro.categoria || '';
            document.getElementById('equip_potencia').value = registro.potencia || '';
            document.getElementById('equip_material').value = registro.material || '';
            document.getElementById('equip_peso').value = registro.peso || '';
            document.getElementById('equip_dimensoes').value = registro.dimensoes || '';
            document.getElementById('equip_cor').value = registro.cor || '';
            document.getElementById('equip_quantidade').value = registro.quantidade || '';
        } else {
            alert(\"Registro não encontrado!\");
        }
    } catch (err) {
        console.error('Erro ao consultar registro:', err);
    }
}

async function deletarEquipamento() {
    const codigo = document.getElementById('equip_id').value;
    if (!codigo) {
        alert(\"Digite o ID para deletar!\");
        return;
    }

    try {
        const response = await fetch(${apiEquipamento}/deletar-equipamento/, {
            method: 'DELETE'
        });

        if (!response.ok) {
            alert(\"Erro ao deletar registro!\");
            return;
        }

        const msg = await response.text();
        alert(msg);
        limparFormularioEquipamento();
    } catch (err) {
        console.error('Erro ao deletar registro:', err);
    }
}

function limparFormularioEquipamento() {
    document.querySelectorAll('#formEquipamento input').forEach(input => input.value = '');
}

document.getElementById('btnCadastrarEquip').addEventListener('click', cadastrarEquipamento);
document.getElementById('btnPesquisarEquip').addEventListener('click', pesquisarEquipamento);
document.getElementById('btnDeletarEquip').addEventListener('click', deletarEquipamento);
document.getElementById('btnLimparEquip').addEventListener('click', limparFormularioEquipamento);


// ==========================================
// MÓDULO USUÁRIO
// ==========================================
async function cadastrarUsuario() {
    const novoRegistro = {
        nome: document.getElementById('user_nome').value,
        email: document.getElementById('user_email').value,
        cpf: document.getElementById('user_cpf').value,
        dataNascimento: document.getElementById('user_dataNascimento').value
    };

    try {
        const response = await fetch(${apiUsuario}/salvar-usuario, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(novoRegistro)
        });

        if (!response.ok) {
            alert(\"Erro ao cadastrar usuário. Verifique os dados.\");
            return;
        }

        alert(\"Cadastro de usuário efetuado com sucesso!\");
        limparFormularioUsuario();
    } catch (err) {
        console.error('Erro ao cadastrar usuário:', err);
    }
}

async function pesquisarUsuario() {
    const codigo = document.getElementById('user_id').value;
    if (!codigo) {
        alert(\"Digite o ID para consultar!\");
        return;
    }

    try {
        const response = await fetch(${apiUsuario}/buscar-usuario/);
        if (!response.ok) {
            alert(\"Usuário não encontrado!\");
            return;
        }

        const registro = await response.json();
        if (registro && registro.id) {
            document.getElementById('user_nome').value = registro.nome || '';
            document.getElementById('user_email').value = registro.email || '';
            document.getElementById('user_cpf').value = registro.cpf || '';
            document.getElementById('user_dataNascimento').value = registro.dataNascimento || '';
        } else {
            alert(\"Usuário não encontrado!\");
        }
    } catch (err) {
        console.error('Erro ao consultar usuário:', err);
    }
}

async function deletarUsuario() {
    const codigo = document.getElementById('user_id').value;
    if (!codigo) {
        alert(\"Digite o ID para deletar!\");
        return;
    }

    try {
        const response = await fetch(${apiUsuario}/deletar-usuario/, {
            method: 'DELETE'
        });

        if (!response.ok) {
            alert(\"Erro ao deletar usuário!\");
            return;
        }

        const msg = await response.text();
        alert(msg);
        limparFormularioUsuario();
    } catch (err) {
        console.error('Erro ao deletar usuário:', err);
    }
}

function limparFormularioUsuario() {
    document.querySelectorAll('#formUsuario input').forEach(input => input.value = '');
}

document.getElementById('btnCadastrarUser').addEventListener('click', cadastrarUsuario);
document.getElementById('btnPesquisarUser').addEventListener('click', pesquisarUsuario);
document.getElementById('btnDeletarUser').addEventListener('click', deletarUsuario);
document.getElementById('btnLimparUser').addEventListener('click', limparFormularioUsuario);


// ==========================================
// MÓDULO MOVIMENTAÇÃO
// ==========================================
async function cadastrarMovimentacao() {
    const novoRegistro = {
        usuario: document.getElementById('mov_usuario').value,
        dataMovimentacao: document.getElementById('mov_dataMovimentacao').value,
        tipoDeMovimentacao: document.getElementById('mov_tipoDeMovimentacao').value,
        modelo: document.getElementById('mov_modelo').value,
        quantidade: parseInt(document.getElementById('mov_quantidade').value) || 0
    };

    try {
        const response = await fetch(${apiMovimentacao}/salvar-movimentacao, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(novoRegistro)
        });

        if (!response.ok) {
            alert(\"Erro ao cadastrar movimentação. Verifique os dados.\");
            return;
        }

        alert(\"Cadastro de movimentação efetuado com sucesso!\");
        limparFormularioMovimentacao();
    } catch (err) {
        console.error('Erro ao cadastrar movimentação:', err);
    }
}

async function pesquisarMovimentacao() {
    const codigo = document.getElementById('mov_id').value;
    if (!codigo) {
        alert(\"Digite o ID para consultar!\");
        return;
    }

    try {
        const response = await fetch(${apiMovimentacao}/buscar-movimentacao/);
        if (!response.ok) {
            alert(\"Movimentação não encontrada!\");
            return;
        }

        const registro = await response.json();
        if (registro && registro.id) {
            document.getElementById('mov_usuario').value = registro.usuario || '';
            document.getElementById('mov_dataMovimentacao').value = registro.dataMovimentacao || '';
            document.getElementById('mov_tipoDeMovimentacao').value = registro.tipoDeMovimentacao || '';
            document.getElementById('mov_modelo').value = registro.modelo || '';
            document.getElementById('mov_quantidade').value = registro.quantidade || '';
        } else {
            alert(\"Movimentação não encontrada!\");
        }
    } catch (err) {
        console.error('Erro ao consultar movimentação:', err);
    }
}

async function deletarMovimentacao() {
    const codigo = document.getElementById('mov_id').value;
    if (!codigo) {
        alert(\"Digite o ID para deletar!\");
        return;
    }

    try {
        const response = await fetch(${apiMovimentacao}/deletar-movimentacao/, {
            method: 'DELETE'
        });

        if (!response.ok) {
            alert(\"Erro ao deletar movimentação!\");
            return;
        }

        const msg = await response.text();
        alert(msg);
        limparFormularioMovimentacao();
    } catch (err) {
        console.error('Erro ao deletar movimentação:', err);
    }
}

function limparFormularioMovimentacao() {
    document.querySelectorAll('#formMovimentacao input').forEach(input => input.value = '');
}

document.getElementById('btnCadastrarMov').addEventListener('click', cadastrarMovimentacao);
document.getElementById('btnPesquisarMov').addEventListener('click', pesquisarMovimentacao);
document.getElementById('btnDeletarMov').addEventListener('click', deletarMovimentacao);
document.getElementById('btnLimparMov').addEventListener('click', limparFormularioMovimentacao);
