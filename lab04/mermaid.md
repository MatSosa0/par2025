%% Código Mermaid para el diagrama de endpoints
flowchart LR
    subgraph API["API RESTful (v1)"]
        direction TB
        subgraph Productos["Recurso: Productos"]
            B1[GET /productos]
            B2[GET /productos/{id}]
            B3[POST /productos]
            B4[PUT /productos/{id}]
            B5[DELETE /productos/{id}]
        end

        subgraph Facturas["Recurso: Facturas"]
            C1[GET /facturas]
            C2[GET /facturas/{id}]
            C3[POST /facturas]
            C4[PUT /facturas/{id}]
            C5[DELETE /facturas/{id}]
        end
    end

    style API fill:#f5f5f5,stroke:#333,stroke-width2px
    style Productos fill:#e3f2fd,stroke:#2196f3
    style Facturas fill:#e8f5e9,stroke:#4caf50