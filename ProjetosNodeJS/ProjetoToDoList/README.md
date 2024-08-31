1. **Escopo Funcional: O que o sistema deve fazer**
Funcionalidades Principais:

Autenticação de Usuários:

Registro e login com verificação de e-mail.
Utilização de JSON Web Tokens (JWT) para autenticação e gerenciamento de sessões.
Gerenciamento de Tarefas:

Adicionar, editar e excluir tarefas.
Marcar tarefas como concluídas e visualizar status.
Organizar tarefas por categorias ou tags.
Ordenar e filtrar tarefas por data, prioridade ou status.
Interface de Usuário:

Interface intuitiva e responsiva utilizando React.
Painel de controle com visualização de tarefas pendentes e concluídas.
Funcionalidade de arrastar e soltar para reordenar tarefas.
Notificações e Alertas:

Notificações para prazos de tarefas e lembretes.
Alertas para atividades importantes.
Histórico e Relatórios:

Visualização do histórico de tarefas concluídas.
Geração de relatórios de produtividade e estatísticas de tarefas.
2. Escopo Não Funcional: Como o sistema deve desempenhar as funções
Desempenho e Escalabilidade:

Segurança:

Criptografia de dados sensíveis, como senhas e tokens de sessão.
Proteção contra ataques comuns (e.g., CSRF, XSS, SQL Injection).
Controle de acesso baseado em permissões de usuário.
Usabilidade:

Interface amigável e intuitiva.
Acessibilidade para diferentes dispositivos (mobile, tablet, desktop).
Performance otimizada para carregamento rápido e responsivo.
Escalabilidade:

Estrutura modular e escalável utilizando Node.js e MongoDB.
Capacidade para adicionar novas funcionalidades e suportar um aumento no número de usuários.
Manutenibilidade:

Código limpo e bem documentado.
Testes automatizados para garantir a estabilidade do sistema.
Atualizações e manutenção contínua.
3. **Objetivos SMART**
Específico: Desenvolver uma aplicação web de To-Do List com funcionalidades de autenticação, gerenciamento de tarefas, e notificações.
Mensurável: A aplicação deve ser capaz de suportar pelo menos 1.000 usuários simultâneos e oferecer uma taxa de resposta de menos de 2 segundos para ações principais.
Atingível: Utilizar tecnologias e frameworks modernos como React, Node.js, MongoDB e JWT, que são amplamente suportados e bem documentados.
Relevante: Melhorar a eficiência e organização das tarefas para os colaboradores da Escola SENAI, ajudando-os a gerenciar suas atividades diárias de forma mais eficaz.
Temporal: Concluir o desenvolvimento e a implementação da aplicação em 3 meses.
4. **Cronograma - Diagrama de Gantt**
Semana 1-2:

Análise de requisitos e definição do escopo.
Pesquisa de tecnologias e ferramentas.
Semana 3-4:

Configuração do ambiente de desenvolvimento.
Implementação da autenticação de usuários.
Semana 5-6:

Desenvolvimento das funcionalidades principais de gerenciamento de tarefas.
Criação da interface de usuário com React.
Semana 7-8:

Implementação das notificações e alertas.
Desenvolvimento de histórico e relatórios.
Semana 9-10:

Testes e ajustes de usabilidade.
Implementação de segurança e revisão de código.
Semana 11-12:

Implantação e treinamento para os usuários finais.
Coleta de feedback e ajustes finais.
5. **Análise de Risco**
Principais Riscos e Mitigações:

Risco de Atrasos no Cronograma:

Mitigação: Planejamento detalhado e revisões regulares do progresso.
Risco de Problemas de Segurança:

Mitigação: Implementação de práticas de segurança recomendadas e testes de segurança.
Risco de Baixa Usabilidade:

Mitigação: Testes com usuários reais e ajustes baseados no feedback.
Risco de Falhas Técnicas:

Mitigação: Testes automatizados e revisão de código por pares.
6. **Recursos**
Equipe:

Desenvolvedores front-end e back-end.
Designer de UI/UX.
Especialista em segurança.
Testadores.
Ferramentas e Tecnologias:

Frontend: React, HTML, CSS.
Backend: Node.js, Express.js.
Banco de Dados: MongoDB.
Autenticação: JSON Web Tokens (JWT).
Ferramentas de Desenvolvimento: Git, Docker (para contêineres), ferramentas de CI/CD.



